package bupt.fnl.dht.service.IdentityServiceImpl;

import bupt.fnl.dht.pojo.Identity;
import bupt.fnl.dht.service.DhtService;
import bupt.fnl.dht.utils.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class DhtServiceImpl implements DhtService {
    private static final String IP = "127.0.0.1";
    private static final String PORT = "30000";

    @Override
    public int insert(Identity identity) {
        return 0;
    }

    @Override
    public Identity resolve(Identity identity) {
        return null;
    }

    @Override
    public List<Node> queryCurrentNodeList() {
        return null;
    }

    public Identity makeConnection(Identity identity) {
        try (Socket sendingSocket = new Socket(IP, Integer.parseInt(PORT))) {
            ObjectOutputStream out = new ObjectOutputStream(sendingSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(sendingSocket.getInputStream()));
            out.writeObject(identity);

        } catch (Exception e) {
            throw new RuntimeException("连接异常");
        }
        return new Identity();
    }
}
