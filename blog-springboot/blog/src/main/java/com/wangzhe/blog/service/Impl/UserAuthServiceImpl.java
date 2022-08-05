package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.common.constant.RedisPrefixConst;
import com.wangzhe.blog.common.result.ResultCode;
import com.wangzhe.blog.dto.EmailDto;
import com.wangzhe.blog.entity.Resource;
import com.wangzhe.blog.entity.UserAuth;
import com.wangzhe.blog.entity.UserAuthDetails;
import com.wangzhe.blog.entity.UserInfo;
import com.wangzhe.blog.exception.BizException;
import com.wangzhe.blog.mapper.ResourceMapper;
import com.wangzhe.blog.mapper.UserAuthMapper;
import com.wangzhe.blog.mapper.UserInfoMapper;
import com.wangzhe.blog.service.EmailService;
import com.wangzhe.blog.service.UserAuthService;
import com.wangzhe.blog.utils.CommonUtil;
import com.wangzhe.blog.utils.JwtTokenUtil;
import com.wangzhe.blog.utils.RedisUtil;
import com.wangzhe.blog.vo.EmailVo;
import com.wangzhe.blog.vo.UserLoginVo;
import com.wangzhe.blog.vo.UserRegisterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.wangzhe.blog.common.result.ResultCode.ACCOUNT_DISABLED;


/**
 * <p>
 * 用户认证信息 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthMapper, UserAuth> implements UserAuthService {
    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(UserRegisterVo userRegisterVo) {
        checkUser(userRegisterVo);
        UserInfo userInfo = UserInfo.builder().nickname("用户").avatar("http://www.baidu.com").build();
        userInfoMapper.insert(userInfo);
        UserAuth userAuth = new UserAuth();
        BeanUtils.copyProperties(userRegisterVo, userAuth);
        String encode = passwordEncoder.encode(userAuth.getPassword());
        userAuth.setPassword(encode);
        userAuth.setUserInfoId(userInfo.getId());
        userAuth.setLoginType("1");
        userAuthMapper.insert(userAuth);
    }

    @Override
    public void sendRegisterMailCode(EmailVo emailVo) {
        LambdaQueryWrapper<UserAuth> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserAuth::getUsername, emailVo.getEmail());
        Long count = userAuthMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new BizException(ResultCode.EMAIL_EXIST);
        }
        //生成验证码
        String code = CommonUtil.randomCode(6);

        //发送验证码
        EmailDto emailDto = new EmailDto();
        emailDto.setTo(emailVo.getEmail());
        emailDto.setSubject("验证码");
        emailDto.setContent("您的验证码为 " + code + " 有效期5分钟，请不要告诉其他哦！");
        emailService.sendSimpleEmail(emailDto);

        String key = RedisPrefixConst.EMAIL_CODE + emailVo.getEmail();
        redisUtil.set(key, code, RedisPrefixConst.CODE_EXPIRE_TIME);

    }

    private void checkUser(UserRegisterVo userRegisterVo) {
        LambdaQueryWrapper<UserAuth> userAuthLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userAuthLambdaQueryWrapper.eq(UserAuth::getUsername, userRegisterVo.getUsername());
        Long aLong = userAuthMapper.selectCount(userAuthLambdaQueryWrapper);
        if (aLong > 0) {
            throw new BizException(ResultCode.USERNAME_EXIST);
        }
        String key = RedisPrefixConst.EMAIL_CODE + userRegisterVo.getUsername();
        String redisCode = (String) redisUtil.get(key);
        if (BeanUtil.isEmpty(redisCode)) {
            throw new BizException(ResultCode.EMAIL_CODE_NULL);
        } else {
            if (!userRegisterVo.getCode().equals(redisCode)) {
                throw new BizException(ResultCode.EMAIL_CODE_ERROR);
            }
        }
    }

    @Override
    public String login(UserLoginVo userLoginVo) {
        UserDetails userDetails = loadUserByUsername(userLoginVo.getUsername());
        if (!passwordEncoder.matches(userLoginVo.getPassword(), userDetails.getPassword())) {
            throw new BizException(ResultCode.USERNAME_OR_PASSWORD_ERROR);
        }
        if (!userDetails.isEnabled()) {
            throw new BizException(ResultCode.ACCOUNT_DISABLED);
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);


        return jwtTokenUtil.generateToken(userDetails);

    }

    public UserDetails loadUserByUsername(String username) {
        LambdaQueryWrapper<UserAuth> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserAuth::getUsername, username);
        Long aLong = userAuthMapper.selectCount(queryWrapper);
        if (aLong < 1) {
            throw new BizException(ResultCode.USERNAME_NOT_EXIST);
        }
        UserAuth userAuth = userAuthMapper.selectOne(queryWrapper);
        UserInfo userInfo = userInfoMapper.selectById(userAuth.getUserInfoId());
        UserAuthDetails userDetails = new UserAuthDetails();
        userDetails.setUserAuth(userAuth);
        userDetails.setUserInfo(userInfo);
        List<Resource> resources = resourceMapper.selectResourceListByUserInfoId(userInfo.getId());
        userDetails.setResourceList(resources);
        return userDetails;
    }
}
