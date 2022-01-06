package com.pgsainia.lottery.domain.activity.service.stateflow;

import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.domain.activity.service.stateflow.event.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nifujia
 * @description
 * @date 2022/1/6
 */
public class StateConfig {

    @Resource
    private ArraignmentState arraignmentState;
    @Resource
    private CloseState closeState;
    @Resource
    private DoingState doingState;
    @Resource
    private EditState editState;
    @Resource
    private OpenState openState;
    @Resource
    private PassState passState;
    @Resource
    private RefuseState refuseState;

    protected final Map<Enum<Constants.ActivityState>, AbstractState> stateGroupMap = new ConcurrentHashMap();

    @PostConstruct
    public void init() {
        stateGroupMap.put(Constants.ActivityState.ARRAIGNMENT, arraignmentState);
        stateGroupMap.put(Constants.ActivityState.CLOSE, closeState);
        stateGroupMap.put(Constants.ActivityState.DOING, doingState);
        stateGroupMap.put(Constants.ActivityState.EDIT, editState);
        stateGroupMap.put(Constants.ActivityState.OPEN, openState);
        stateGroupMap.put(Constants.ActivityState.PASS, passState);
        stateGroupMap.put(Constants.ActivityState.REFUSE, refuseState);
    }

}
