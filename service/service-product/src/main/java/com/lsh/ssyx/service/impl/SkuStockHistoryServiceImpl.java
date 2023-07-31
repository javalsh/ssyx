package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.product.SkuStockHistory;
import com.lsh.ssyx.service.SkuStockHistoryService;
import com.lsh.ssyx.mapper.SkuStockHistoryMapper;
import org.springframework.stereotype.Service;

/**
* @author liushaohua
* @description 针对表【sku_stock_history(sku的库存历史记录)】的数据库操作Service实现
* @createDate 2023-07-31 16:56:44
*/
@Service
public class SkuStockHistoryServiceImpl extends ServiceImpl<SkuStockHistoryMapper, SkuStockHistory>
    implements SkuStockHistoryService{

}




