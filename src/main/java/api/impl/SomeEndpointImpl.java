package api.impl;

import api.SomeEndpoint;
import api.dto.FinishRequest;
import api.parameters.ErrorOption;

public class SomeEndpointImpl implements SomeEndpoint {
    @Override
    public void finish(String taskName, FinishRequest result, ErrorOption err) {
        System.out.println(taskName + "finish");
    }


    @Override
    public void succeed(String taskName, Object result, ErrorOption err) {
        System.out.println(taskName + "succeed");
    }
}
