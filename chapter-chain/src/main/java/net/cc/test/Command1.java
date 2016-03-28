package net.cc.test;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.util.logging.Logger;

/**
 * Created by zhonghua on 16/1/28.
 */
public class Command1 implements Command {

    private Logger logger = Logger.getAnonymousLogger();

    @Override
    public boolean execute(Context context) throws Exception {

        logger.info("command1 execute()");
        return false;
    }
}