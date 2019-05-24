package edu.harrisburgu.cisc525.app;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    // private static final String LOCALHOST_GREETINGS_SERVER = "//saintgoretti/GreetingsServer";
    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static GreetingsInterface look_up;

    public static void main(String... args) throws IOException, NotBoundException {
        if (args.length < 2) {
            LOGGER.info("**** java edu.harrisburgu.cisc525.app.Main server naming | client namming <text> ****");
            return;
        }
        LOGGER.info("mode: {}", args[0]);
        if (args[0].equalsIgnoreCase("client")) {
            if (args.length < 3) {
                LOGGER.info("**** java edu.harrisburgu.cisc525.app.Main client host <text> ****");
                return;
            }
            look_up = (GreetingsInterface) Naming.lookup(args[1]);
            String name = String.format("%s from %s/%s", args[2], InetAddress.getLocalHost().getHostName(),
                    ManagementFactory.getRuntimeMXBean().getName());
            LOGGER.info("Calling remote greetings with {}", name);
            LOGGER.info("Received {}", look_up.hello(name));
        } else if (args[0].equalsIgnoreCase("server")) {
            if (args.length < 2) {
                LOGGER.info("**** java edu.harrisburgu.cisc525.app.Main server ****");
                return;
            }
            try {
                Naming.rebind(args[1], new GreetingsServer());
                LOGGER.info("Server ready");
            } catch (Exception e) {
                System.err.println("Server exception: " + e.toString());
                e.printStackTrace();
            }
        } else {
            LOGGER.info(">>> java edu.harrisburgu.cisc525.app.Main server port | client host port <text> <<<");
        }
    }
}