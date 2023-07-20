package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.sys.Ware;
import com.lsh.ssyx.service.WareService;
import com.lsh.ssyx.mapper.WareMapper;
import org.springframework.stereotype.Service;

/**
* @author liushaohua
* @description 针对表【ware(仓库表)】的数据库操作Service实现
* @createDate 2023-07-20 16:30:49
*/
@Service
public class WareServiceImpl extends ServiceImpl<WareMapper, Ware>
    implements WareService{

}




