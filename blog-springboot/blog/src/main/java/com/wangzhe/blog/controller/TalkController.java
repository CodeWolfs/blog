package com.wangzhe.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.dto.SelectTalkDto;
import com.wangzhe.blog.service.TalkService;
import com.wangzhe.blog.vo.DeleteArticleListVo;
import com.wangzhe.blog.vo.InsertTalkVo;
import com.wangzhe.blog.vo.SelectTalksVo;
import com.wangzhe.blog.vo.UpdateTalkVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-09-30
 */
@RestController
@Api(tags = "说说管理")
public class TalkController {
    @Autowired
    private TalkService talkService;


    @ApiOperation("后台发布说说")
    @PostMapping("/admin/talk")
    public Result<?> insertTalk(@RequestBody @Validated InsertTalkVo insertTalkVo) {
        talkService.insertTalk(insertTalkVo);
        return Result.ok();
    }

    @ApiOperation("后台查询说说详情")
    @GetMapping("/admin/talk/{id}")
    @ApiImplicitParam(name = "id", value = "说说id", dataTypeClass = String.class, paramType = "path", required = true)
    public Result<SelectTalkDto> selectTalk(@PathVariable("id") @Valid @NotNull(message = "说说id不能为空") Integer id) {
        SelectTalkDto selectTalkDto = talkService.selectTalk(id);
        return Result.ok(selectTalkDto);
    }

    @ApiOperation("后台查询说说列表")
    @GetMapping("/admin/talks")
    public Result<Page<SelectTalkDto>> selectTalks(@Validated SelectTalksVo selectTalksVo) {
        Page<SelectTalkDto> selectTalkDtoPage = talkService.selectTalks(selectTalksVo);
        return Result.ok(selectTalkDtoPage);
    }

    @ApiOperation("后台更新说说")
    @PutMapping("/admin/talk")
    public Result<?> updateTalk(@RequestBody  @Validated UpdateTalkVo updateTalkVo) {
        talkService.updateTalk(updateTalkVo);
        return Result.ok();
    }

    @ApiOperation("后台删除说说")
    @DeleteMapping("/admin/talk/{id}")
    public Result<?> deleteTalk(@Valid @PathVariable("id") Integer id) {
        talkService.deleteTalk(id);

        return Result.ok();
    }

}
