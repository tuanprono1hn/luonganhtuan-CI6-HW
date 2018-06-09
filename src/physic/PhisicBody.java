package physic;

import base.GameObject;

public interface PhisicBody {

    BoxCollider getBoxCollider();

    void getHit(GameObject gameObject);
}
