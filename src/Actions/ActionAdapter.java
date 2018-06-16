package Actions;

import base.GameObject;

public class ActionAdapter implements Action{ //abstract class dac biet mang 1 so dd interface
    @Override
    public boolean run(GameObject owner) {
        return false;
    }

    @Override
    public void reset() {

    }

    public void add(){

    }
}
