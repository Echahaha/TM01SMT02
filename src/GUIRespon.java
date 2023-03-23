import Model.ResponseModel;
import network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class GUIRespon {
    private JPanel tugas;
    private JTextField msg;
    private JTextField status;
    private JTextField comment;
    private JButton exitButton;
    private JButton submitButton;
    private JButton minimize;

    public JPanel getTugas() {
        return tugas;
    }
    public JButton getMinimize() {
        return minimize;
    }

    public GUIRespon() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msg.setText("");
                status.setText("");
                comment.setText("");
                try{
                    ConnectURI connection = new ConnectURI();
                    URL myAddress = connection.buildURL("http://harber.mimoapps.xyz/api/getaccess.php");
                    String response = connection.getResponseFromHttpUrl(myAddress);

                    JSONArray responseJSON = new JSONArray(response);
                    ArrayList<ResponseModel> responseModel = new ArrayList<>();
                    for (int i = 0; i < responseJSON.length(); i++) {
                        ResponseModel resModel = new ResponseModel();
                        JSONObject myJSONObject = responseJSON.getJSONObject(i);
                        resModel.setMsg(myJSONObject.getString("message"));
                        resModel.setStatus(myJSONObject.getString("status"));
                        resModel.setComment(myJSONObject.getString("comment"));
                        responseModel.add(resModel);
                    }
                    for(ResponseModel respond : responseModel){
                        msg.setText(respond.getMsg());
                        status.setText(respond.getStatus());
                        comment.setText(respond.getComment());
                    }
                } catch (Exception connect){
                    System.out.println(connect);
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
