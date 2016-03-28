package net.cc.test;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;

import java.util.HashMap;

/**
 * Created by zhonghua on 16/1/28.
 */
public class CommandChain extends ChainBase {

    public CommandChain() {
        addCommand(new Command1());
        addCommand(new Command2());
        addCommand(new Command3());
    }

    public static void main(String[] args) throws Exception {

        CommandChain cmd = new CommandChain();
        Context ctx = new ContextBase();
        cmd.execute(ctx);
    }
}