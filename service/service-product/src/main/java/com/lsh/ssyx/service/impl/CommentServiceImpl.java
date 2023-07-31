package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.product.Comment;
import com.lsh.ssyx.service.CommentService;
import com.lsh.ssyx.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author liushaohua
* @description 针对表【comment(商品评价)】的数据库操作Service实现
* @createDate 2023-07-31 16:56:44
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




