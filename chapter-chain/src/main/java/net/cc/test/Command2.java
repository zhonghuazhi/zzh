package net.cc.test;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.util.logging.Logger;

/**
 * Created by zhonghua on 16/1/28.
 */
public class Command2 implements Command{

    private Logger logger = Logger.getAnonymousLogger();

    @Override
    public boolean execute(Context context) throws Exception {

        logger.info("command2 execute()");
        return false;
    }
}