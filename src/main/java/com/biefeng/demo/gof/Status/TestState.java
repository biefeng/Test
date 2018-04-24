package com.biefeng.demo.gof.Status;

public class TestState {
    public static void main(String[] args) {
        Context context = new Context();
        context.getState().printState();
        context.changeState(Context.BOLLING_WATER);
        context.getState().printState();
    }
}

class Context {
    private static final State DEFAULT_WATER_STATE=new ColdWater();

    //此处状态名用枚举其实更好
    public static final String COLD_WATER="ColdWater";
    public static final String WARM_WATER="WarmWater";
    public static final String BOLLING_WATER="BollingWater";
    private State state=DEFAULT_WATER_STATE;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    //根据状态名改变state指向的对象，此处需要注意，State具体的实现类需要和Context放在同一包下
    public void changeState(String stateName) {
        String contextName = this.getClass().getName();
        String classPath = contextName.substring(0,contextName.lastIndexOf(".")+1);
        String className = classPath + stateName;

        try {
            Class clazz = Class.forName(className);
            state = (State) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

interface State {
    void printState();
}

class BollingWater implements State {

    @Override
    public void printState() {
        System.out.println("Bolling Water");
    }
}

class ColdWater implements State {

    @Override
    public void printState() {
        System.out.println("Cold Water");
    }
}

class WarmWater implements State {
    @Override
    public void printState() {
        System.out.println("Warm Water");
    }
}


