import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.sql.*;
 
public class ApiExplorer extends Thread {
	
	
	// tag값의 정보를 가져오는 함수
	public static String getTagValue(String tag, Element eElement) {
		Node nValue=null;
        
        NodeList x= eElement.getElementsByTagName(tag);
        Node test=x.item(0);
        NodeList t=null;
        if(test!=null) {
        	t= test.getChildNodes();
        	if((Node)t.item(0)!=null) {nValue=(Node)t.item(0);}
        }
        if(nValue==null) return null;
        return nValue.getNodeValue();
	}

	// tag값의 정보를 가져오는 함수
	public static String getTagValue(String tag, String childTag, Element eElement) {

		//결과를 저장할 result 변수 선언
		String result = "";

		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

		for(int i = 0; i < eElement.getElementsByTagName(childTag).getLength(); i++) {

			//result += nlList.item(i).getFirstChild().getTextContent() + " ";
			result += nlList.item(i).getChildNodes().item(0).getTextContent() + " ";
		}

		return result;
	}
	
 
    // 다운로드 받은 문자열을 저장할 변수
    private static String xml;
    // 파싱한 결과를 저장할 리스트 - 몇개인지 모르므로 배열이 아니고 ArrayList로 만들어야 합니다.
    static List<String> data = new ArrayList<String>();
    

    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	
		
 
        try {
        	// parsing할 url 지정(API 키 포함해서)
        	StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson"); /*URL*/
        	String key = "private Key";
        	urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + key); /*Service Key*/
        	//urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        	//urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("3000", "UTF-8")); /*한 페이지 결과 수*/
        	urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode("20220201", "UTF-8")); /*검색할 생성일 범위의 시작*/
        	urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode("20220420", "UTF-8")); /*검색할 생성일 범위의 종료*/
        		        
        		        
        	URL url = new URL(urlBuilder.toString());
        		        
        	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        	conn.setRequestMethod("GET");
        	conn.setRequestProperty("Content-type", "application/json");
        	System.out.println("Response code: " + conn.getResponseCode());
        		        
        	BufferedReader rd;
        		        
        	if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
        		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        		} else {
        			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        		}
        	StringBuilder sb = new StringBuilder();
        	String line;
        		        
        	while ((line = rd.readLine()) != null) {
        		sb.append(line);
        		}
        	xml = sb.toString();
        	rd.close();
        	conn.disconnect();
 
        } catch (Exception e) {
            System.out.println("다운로드에러" + e.getMessage());
 
        }
        System.out.println(xml);
 
        // 파싱
        try {
            // 자신의 static 메서드를 가지고 객체를 생성 : 싱글톤 패턴
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // 다른 클래스의 객체를 가지고, 객체를 생성하면 팩토리 패턴.
            DocumentBuilder documentbuilder = factory.newDocumentBuilder(); //// 팩토리 메서드 패턴  공장에서 찍어줌
            // 문자열을 InputStream으로 변환
            
            
            InputStream is = new ByteArrayInputStream(xml.getBytes());
            Document doc = documentbuilder.parse(is);
            
            // xml을 메모리에 펼쳐놓고 루트를 elemnt에 저장
            //Element element = doc.getDocumentElement();
 
            // 파싱할 태그의 리스트를 찾아온다
            // tmx 태그 전체를 list에 저장
            //NodeList list = element.getElementsByTagName("seq");
            
            
         			
         	// 파싱할 tag
         	NodeList nList = doc.getElementsByTagName("item");
         	
         	System.out.println(nList.getLength());
         	
         	
            // 리스트를 순회하면서 데이터를 data에 추가
            for (int i = 0; i < nList.getLength(); i++) {
            	Node nNode = nList.item(i);
            	
    			
				Element eElement = (Element) nNode;
				
				System.out.println("번호 : "  + getTagValue("seq", eElement));
				System.out.println("등록일시분초 : " + getTagValue("createDt", eElement));
				System.out.println("사망자 수 : " + getTagValue("deathCnt", eElement));
				System.out.println("시도명(한글) : " + getTagValue("gubun", eElement));
				System.out.println("시도명(영어) : " + getTagValue("gubunEn", eElement));
				System.out.println("전일대비 증감 수: " + getTagValue("incDec", eElement));
				System.out.println("격리 해제 수 : " + getTagValue("isolClearCnt", eElement));
				System.out.println("10만명당 발생률: " + getTagValue("qurRate", eElement));
				System.out.println("기준일시: " + getTagValue("stdDay", eElement));
				System.out.println("확진자 수 : " + getTagValue("defCnt", eElement));
				System.out.println("해외 유입 수 : " + getTagValue("overFlowCnt", eElement));
				System.out.println("지역발생 수 : " + getTagValue("localOccCnt", eElement));
				
				
				// 연결하기
				Connection connection = null;
				String db_url="database_url";
				String user="database id";
				String password="database pw";
				
				Class.forName("org.mariadb.jdbc.Driver");
				connection = DriverManager.getConnection(db_url, user, password);
				
				Statement stmt = null;
				
				try {
					String sql = "insert into table(seq, createDt, deathCnt, gubun, gubunEn, incDec, isolClearCnt, qurRate, stdDay, defCnt, overFlowCnt, localOccCnt) values('"+getTagValue("seq", eElement)+"','"+getTagValue("createDt", eElement)+"','"+getTagValue("deathCnt", eElement)+"','"+getTagValue("gubun", eElement)+"','"+getTagValue("gubunEn", eElement)+"','"+getTagValue("incDec", eElement)+"','"+getTagValue("isolClearCnt", eElement)+"','"+getTagValue("qurRate", eElement)+"','"+getTagValue("stdDay", eElement)+"','"+getTagValue("defCnt", eElement)+"','"+getTagValue("overFlowCnt",eElement)+"','"+getTagValue("localOccCnt",eElement)+"')";
					stmt = connection.createStatement();
					// 삽입 수정 삭제는 update로 실행해준다
					stmt.executeUpdate(sql);
					System.out.println("Insert to userInfo was successful");
				} catch (SQLException e) {
					System.out.println("Insert Failed");
					System.out.println("SQLException: " + e.getMessage());
				} finally {
					if (stmt != null) {
						stmt.close();
					}
					if (connection != null) {
						connection.close();
					}
				}
				
				
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }

		
    }
}
