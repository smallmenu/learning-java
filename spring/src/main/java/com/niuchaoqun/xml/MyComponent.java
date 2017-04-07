package com.niuchaoqun.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    public MyEngine myEngine;

    @Autowired
    public MyComponent(MyEngine myEngine) {
        this.myEngine = myEngine;
    }

    public MyEngine getMyEngine() {
        return myEngine;
    }

    @Override
    public String toString() {
        return "MyComponent{}";
    }
}
