import Model.ResponseModel;
import network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect1 {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL("https://harber.mimoapps.xyz/api/getaccess.php");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
        System.out.println(response);

        JSONArray ResponseJSON = new JSONArray(response);
        ArrayList<ResponseModel> responseModel = new ArrayList<>();
        for(int i=0;i<ResponseJSON.length();i++){
            ResponseModel resModel = new ResponseModel();
            JSONObject myJSONObject = ResponseJSON.getJSONObject(i);
            resModel.setMsg(myJSONObject.getString("massage"));
            resModel.setStatus(myJSONObject.getString("status"));
            resModel.setComments(myJSONObject.getString("comment"));
            responseModel.add(resModel);
        }
        System.out.println("Massage are:");
        for(int index=0; index<responseModel.size(); index++){
            System.out.println("MASSAGE : " + responseModel.get(index).getMsg());
            System.out.println("STATUS : " + responseModel.get(index).getStatus());
            System.out.println("COMMENT : " + responseModel.get(index).getComments());
        }
    }
}
