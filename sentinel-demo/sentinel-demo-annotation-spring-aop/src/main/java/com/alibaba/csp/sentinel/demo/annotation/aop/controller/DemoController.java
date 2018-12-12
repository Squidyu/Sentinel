/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.demo.annotation.aop.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.demo.annotation.aop.service.TestService;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

/**
 * @author Eric Zhao
 */
@RestController
public class DemoController {

    @Autowired
    private TestService service;

    @GetMapping("/foo")
    public String foo() throws Exception {
        service.test();
        return service.hello(System.currentTimeMillis());
    }

//    @GetMapping("/iptest")
//    public String ipTest(HttpServletRequest request, HttpResponse response){
//
//        String address = request.getRemoteAddr();
//        Entry entry = null;
//        try {
//            entry = SphU.entry("iptest", EntryType.IN, 1, address);
//            return service.ipTest(address);
//        } catch (BlockException ex) {
//            ex.printStackTrace();
//        } catch (Throwable ex) {
//            Tracer.trace(ex);
//            throw ex;
//        } finally {
//            if (entry != null) {
//                entry.exit();
//            }
//        }
//        return null;
//    }

}
