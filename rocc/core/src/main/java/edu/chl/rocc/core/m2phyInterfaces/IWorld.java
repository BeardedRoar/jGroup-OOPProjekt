package edu.chl.rocc.core.m2phyInterfaces;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;

/**
 * Created by Yen on 2015-05-11.
 */
public interface IWorld {



    public void createBody(BodyDef def);

    public void destroyBody(Body body);

    //public hashCode();

    //public void step();
}