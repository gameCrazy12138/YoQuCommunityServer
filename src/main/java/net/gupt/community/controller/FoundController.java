package net.gupt.community.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import net.gupt.community.annotation.AuthToken;
import net.gupt.community.entity.CodeMsg;
import net.gupt.community.entity.Found;
import net.gupt.community.entity.PageInfoBean;
import net.gupt.community.entity.Result;
import net.gupt.community.service.FoundService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * <h3>gupt-community</h3>
 * <p>失物找回web控制层</p>
 *
 * @author : Cui
 * @date : 2019-07-30 21:01
 **/
@AuthToken
@RestController
@RequestMapping(value = "/found", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FoundController {

    private final FoundService foundService;
    public FoundController(FoundService foundService) {
        this.foundService = foundService;
    }

    @ResponseBody
    @RequestMapping(value = "/getFounds", method = RequestMethod.GET)
    public Result getFounds(@RequestParam(value = "pageNum") Integer pageNum,
                              @RequestParam(value = "pageSize") Integer pageSize) {
        PageInfo<Found> foundPageInfo = foundService.getFounds(pageNum, pageSize);
        if (foundPageInfo == null) {
            return Result.error(CodeMsg.FAILED);
        }
        return Result.success(CodeMsg.SUCCESS, new PageInfoBean<>(foundPageInfo));
    }

    @ResponseBody
    @RequestMapping(value = "/postFound" , method =  RequestMethod.POST ,consumes = "application/json")
    public Result postFound(@RequestBody Found found){
        int rows = foundService.postFound(found);
        if(rows > 0 ){
            return  Result.success(CodeMsg.POST_SUCCESS,found.getId());
        }
        return Result.error(CodeMsg.POST_FAILED);
    }
    @ResponseBody
    @RequestMapping(value = "updateFoundStatus" , method = RequestMethod.POST , consumes =  "application/json")
    public Result updateFoundStatus(@RequestBody Found found){
        int rows = foundService.updateFoundStatus(found);
        if(rows > 0 ){
            return  Result.success(CodeMsg.UPDATE_SUCESS);
        }
        return  Result.error(CodeMsg.UPDATE_FAILED);
    }
}