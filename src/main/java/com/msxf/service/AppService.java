package com.example.service;

import com.example.domain.App;
import com.example.dto.AppDto;
import com.example.repository.AppRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    private AppRepository appRepository;

    public void addApp(AppDto appDto){
        App app = new App();
        BeanUtils.copyProperties(appDto, app);
        appRepository.save(app);
    }

    public boolean updateApp(AppDto appDto){
        boolean result = false;
        App app = appRepository.findOne(appDto.getId());
        if(app == null){
            return result;
        }
        BeanUtils.copyProperties(appDto, app);
        appRepository.save(app);
        return !result;
    }

    public List<App> listApps(){
        return appRepository.findAll();
    }
}
