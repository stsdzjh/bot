package com.fourany.botserver.services.impls;

import com.fourany.botserver.services.RasaService;
import com.fourany.common.entities.R;
import com.fourany.common.enums.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.Yaml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年11月25日 15:19
 */
@Service
public class RasaServiceImpl implements RasaService {
    @Autowired
    RestTemplate restTemplate;
    @Value("${config.rasa.host}")
    private String rasaHost;
    @Value("${config.rasa.port}")
    private String rasaPort;

    private String getRasaApiUrl(){
        return "http://" + rasaHost + ":" + rasaPort + "/";
    }

    @Override
    public R getServerHealth() {
        String healthStr = restTemplate.getForObject(getRasaApiUrl(), String.class);
        return R.result(ResultInfo.DEFAULT_SUCCESS,healthStr);
    }

    @Override
    public R getServerVersion() {
        Object obj = restTemplate.getForObject(getRasaApiUrl() + "version", Object.class);
        return R.result(ResultInfo.DEFAULT_SUCCESS,obj);
    }

    @Override
    public R getServerInfo() {

        Object obj = restTemplate.getForObject(getRasaApiUrl() + "status", Object.class);
        return R.result(ResultInfo.DEFAULT_SUCCESS,obj);
    }

    @Override
    public R modelTrain() {
        Map<String, Object> map = new HashMap<>();
        map.put("pipelines","aaa");
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("bbbb","1111");
        list.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("bbbb","1111");
        list.add(map2);

        map.put("list",list);
        Yaml yaml = new Yaml();

        String output = yaml.dumpAsMap(map);
        System.out.println(output);
        return null;
    }
}
