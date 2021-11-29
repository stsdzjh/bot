package com.fourany.botserver.services;

import com.fourany.common.entities.R;
import com.fourany.common.enums.ResultInfo;

public interface RasaService {
    public R getServerHealth();
    public R getServerVersion();
    public R getServerInfo();

    public R modelTrain();

}
