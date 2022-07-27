import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8080)){    //将服务端创建在端口8080上
            System.out.println("正在等待客户端连接...");
            Socket socket = server.accept();
            System.out.println("客户端已连接，IP地址为："+socket.getInetAddress().getHostAddress());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));  //通过
            System.out.println("接收到客户端数据：");
            while (reader.ready()) System.out.println(reader.readLine());   //ready是判断当前流中是否还有可读内容
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("HTTP/1.1 200 Accepted\r\n");   //200是响应码，Http协议规定200为接受请求，400为错误的请求，404为找不到此资源（不止这些，还有很多）
            writer.write("\r\n");   //在请求头写完之后还要进行一次换行，然后写入我们的响应实体（会在浏览器上展示的内容）
            writer.write("lbwnb!");
            writer.flush();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
//        try(ServerSocket server=new ServerSocket(8080)){
//            System.out.println("connecting…");
//            Socket socket = server.accept();
//            System.out.println("客户端已连接，IP地址为："+socket.getInetAddress().getHostAddress());
//            InputStream in=socket.getInputStream();
//            System.out.println("接收到客户端数据：");
//            while (true){
//                int i=in.read();
//                if(i==-1) break;
//                System.out.print((char)i);
//            }
////            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
////            System.out.println(reader.readLine());
//            //server.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

}
