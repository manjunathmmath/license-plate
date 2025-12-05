package tradebot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tradebot.domain.pnd.*;
import tradebot.service.*;
import tradebot.service.pnd.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Controller
@RequestMapping("/pnd/api")
public class PndDashboardController {
    @Autowired
    private CustomConfigurationService customConfigurationService;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    PndBagObjectService pndBagObjectService;

    @Autowired
    PndBagObjectGeometrieService pndBagObjectGeometrieService;

    @Autowired
    PndBagObjectOorspronkelijkBouwjaarService pndBagObjectOorspronkelijkBouwjaarService;

    @Autowired
    PndBagObjectStatusService pndBagObjectStatusService;

    @Autowired
    PndBagObjectGeconstateerdService pndBagObjectGeconstateerdService;

    @Autowired
    PndBagObjectDocumentnummerService pndBagObjectDocumentnummerService;

    @Autowired
    PndBagObjectDocumentdatumService pndBagObjectDocumentdatumService;

    @Autowired
    PndBagObjectVoorkomenService pndBagObjectVoorkomenService;


    @GetMapping(path = {"/geAllBagObjects"})
    @ResponseBody
    public Map<String, Object> geAllBagObjects(Model model,
                                               @RequestParam Map<String, String> reqParam) throws Exception {
        Map<String, Object> data = new HashMap<>();
        EntityManager session = entityManagerFactory.createEntityManager();
        String dir = reqParam.get("dir");
        String file = reqParam.get("file");

        List<String> columns = new ArrayList<>();
        columns.add("A.ID AS ID");
        columns.add("A.FILE AS FILE");
        columns.add("A.FOLDER AS FOLDER");
        columns.add("A.IDENTIFICATIE AS IDENTIFICATIE");
        columns.add("B.POST_LIST AS POST_LIST");
        columns.add("C.GECONSTATEERD AS GECONSTATEERD");
        columns.add("D.DOCUMENTDATUM AS DOCUMENTDATUM");
        columns.add("E.DOCUMENTNUMMER AS DOCUMENTNUMMER");
        columns.add("F.OORSPRONKELIJK_BOUWJAAR AS OORSPRONKELIJK_BOUWJAAR");
        columns.add("G.STATUS AS STATUS");
        columns.add("H.BEGIN_GELDIGHEID AS BEGIN_GELDIGHEID");
        columns.add("H.TIJDSTIP_REGISTRATIE AS TIJDSTIP_REGISTRATIE");
        columns.add("H.TIJDSTIP_REGISTRATIELV AS TIJDSTIP_REGISTRATIELV");
        columns.add("H.VOORKOMENIDENTIFICATIE AS VOORKOMENIDENTIFICATIE");

        String query = "";
        query += "SELECT " + String.join(",", columns);
        query += " FROM  ";
        query += " PND_BAG_OBJECT A";
        query += " LEFT JOIN  PND_BAG_OBJECT_GEOMETRIE B ON A.ID = B.BAG_OBJECT";
        query += " LEFT JOIN  PND_BAG_OBJECT_GECONSTATEERD C ON A.ID = C.BAG_OBJECT";
        query += " LEFT JOIN  PND_BAG_OBJECT_DOCUMENTDATUM D ON A.ID = D.BAG_OBJECT";
        query += " LEFT JOIN  PND_BAG_OBJECT_DOCUMENTNUMMER E ON A.ID = E.BAG_OBJECT";
        query += " LEFT JOIN  PND_BAG_OBJECT_OORSPRONKELIJK_BOUWJAAR F ON A.ID = F.BAG_OBJECT";
        query += " LEFT JOIN  PND_BAG_OBJECT_STATUS G ON A.ID = G.BAG_OBJECT";
        query += " LEFT JOIN  PND_BAG_OBJECT_VOORKOMEN H ON A.ID = H.BAG_OBJECT";

        query += " WHERE 1=1";

        if (isNotEmpty(dir)) {
            query += " AND A.FOLDER='" + dir + "'";
        }

        if (isNotEmpty(file)) {
            query += " AND A.FILE='" + file + "'";
        }

        query += " ORDER BY A.IDENTIFICATIE";

        System.out.println(query);

        List<Object[]> listResult = session.createNativeQuery(query).getResultList();
        List<Object> dataSource = new ArrayList<>();
        session.close();
        for (Object[] field : listResult) {
            Map<String, String> row = new HashMap<>();
            row.put("ID", field[0].toString());
            row.put("FILE", field[1] != null ? field[1].toString() : " ");
            row.put("FOLDER", field[2] != null ? field[2].toString() : " ");
            row.put("IDENTIFICATIE", field[3] != null ? field[3].toString() : " ");
            row.put("POST_LIST", field[4] != null ? field[4].toString() : " ");
            row.put("GECONSTATEERD", field[5] != null ? field[5].toString() : " ");
            row.put("DOCUMENTDATUM", field[6] != null ? field[6].toString() : " ");
            row.put("DOCUMENTNUMMER", field[7] != null ? field[7].toString() : " ");
            row.put("OORSPRONKELIJK_BOUWJAAR", field[8] != null ? field[8].toString() : " ");
            row.put("STATUS", field[9] != null ? field[9].toString() : " ");
            row.put("BEGIN_GELDIGHEID", field[10] != null ? field[10].toString() : " ");
            row.put("TIJDSTIP_REGISTRATIE", field[11] != null ? field[11].toString() : " ");
            row.put("TIJDSTIP_REGISTRATIELV", field[12] != null ? field[12].toString() : " ");
            row.put("VOORKOMENIDENTIFICATIE", field[13] != null ? field[13].toString() : " ");
            dataSource.add(row);
        }
        data.put("data", dataSource);
        return data;
    }

    @GetMapping(path = {"/showDirectory"})
    @ResponseBody
    public Map<String, List<String>> showDirectory(Model model) {
        String directoryPath = "C:\\Users\\manju\\Projects\\Sibian";
        Path dir = Paths.get(directoryPath);
        Map<String, List<String>> allFiles = new HashMap<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                String dirName = entry.getFileName().toString();
                if (Files.isDirectory(entry)) {
                    if (!allFiles.containsKey(dirName)) {
                        allFiles.put(dirName, listAllFiles(entry));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allFiles;
    }

    private List<String> listAllFiles(Path currentPath) {
        List<String> files = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentPath)) {
            for (Path entry : stream) {
                String name = entry.getFileName().toString();
                if (!Files.isDirectory(entry)) {
                    files.add(name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }


    @GetMapping(path = {"/loadXmlData"})
    @ResponseBody
    public Map<String, String> loadXmlData(Model model, @RequestParam Map<String, String> reqParam) throws Exception {
        Map<String, String> data = new HashMap<>();
        String dir = reqParam.get("dir");
        String file = reqParam.get("file");
        String filePath = "C:\\Users\\manju\\Projects\\Sibian\\" + dir + "\\" + file;
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        NodeList nodeList = document.getElementsByTagName("sl:stand");


        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            String identificatie = element.getElementsByTagName("Objecten:identificatie").item(0).getTextContent();
            System.out.println(identificatie);
            PndBagObject pndBagObject = this.pndBagObjectService.findByIdentificatie(identificatie);
            if (pndBagObject == null) {
                pndBagObject = new PndBagObject();
                pndBagObject.setIdentificatie(identificatie);
                pndBagObject.setFolder(dir);
                pndBagObject.setFile(file);
                this.pndBagObjectService.save(pndBagObject);
                String posList = element.getElementsByTagName("gml:posList").item(0).getTextContent();
                if (isNotEmpty(posList)) {
                    PndBagObjectGeometrie geometrie = new PndBagObjectGeometrie();
                    geometrie.setBagObject(pndBagObject.getId().toString());
                    geometrie.setPostList(posList);
                    this.pndBagObjectGeometrieService.save(geometrie);
                }

                String oorspronkelijkBouwjaar = element.getElementsByTagName("Objecten:oorspronkelijkBouwjaar").item(0).getTextContent();
                if (isNotEmpty(oorspronkelijkBouwjaar)) {
                    PndBagObjectOorspronkelijkBouwjaar bagObjectOorspronkelijkBouwjaar = new PndBagObjectOorspronkelijkBouwjaar();
                    bagObjectOorspronkelijkBouwjaar.setBagObject(pndBagObject.getId().toString());
                    bagObjectOorspronkelijkBouwjaar.setOorspronkelijkBouwjaar(oorspronkelijkBouwjaar);
                    this.pndBagObjectOorspronkelijkBouwjaarService.save(bagObjectOorspronkelijkBouwjaar);
                }

                String status = element.getElementsByTagName("Objecten:status").item(0).getTextContent();

                if (isNotEmpty(status)) {
                    PndBagObjectStatus pndBagObjectStatus = new PndBagObjectStatus();
                    pndBagObjectStatus.setBagObject(pndBagObject.getId().toString());
                    pndBagObjectStatus.setStatus(status);
                    this.pndBagObjectStatusService.save(pndBagObjectStatus);
                }

                String geconstateerd = element.getElementsByTagName("Objecten:geconstateerd").item(0).getTextContent();
                if (isNotEmpty(geconstateerd)) {
                    PndBagObjectGeconstateerd pndBagObjectGeconstateerd = new PndBagObjectGeconstateerd();
                    pndBagObjectGeconstateerd.setBagObject(pndBagObject.getId().toString());
                    pndBagObjectGeconstateerd.setGeconstateerd(geconstateerd);
                    this.pndBagObjectGeconstateerdService.save(pndBagObjectGeconstateerd);
                }


                String documentdatum = element.getElementsByTagName("Objecten:documentdatum").item(0).getTextContent();

                if (isNotEmpty(documentdatum)) {
                    PndBagObjectDocumentdatum pndBagObjectDocumentdatum = new PndBagObjectDocumentdatum();
                    pndBagObjectDocumentdatum.setBagObject(pndBagObject.getId().toString());
                    pndBagObjectDocumentdatum.setDocumentdatum(documentdatum);
                    this.pndBagObjectDocumentdatumService.save(pndBagObjectDocumentdatum);
                }
                String documentnummer = element.getElementsByTagName("Objecten:documentnummer").item(0).getTextContent();
                if (isNotEmpty(documentnummer)) {
                    PndBagObjectDocumentnummer bagObjectDocumentnummer = new PndBagObjectDocumentnummer();
                    bagObjectDocumentnummer.setBagObject(pndBagObject.getId().toString());
                    bagObjectDocumentnummer.setDocumentnummer(documentnummer);
                    this.pndBagObjectDocumentnummerService.save(bagObjectDocumentnummer);
                }

                String voorkomenidentificatie = element.getElementsByTagName("Historie:voorkomenidentificatie").item(0).getTextContent();
                String beginGeldigheid = element.getElementsByTagName("Historie:beginGeldigheid").item(0).getTextContent();
                String tijdstipRegistratie = element.getElementsByTagName("Historie:tijdstipRegistratie").item(0).getTextContent();
                String tijdstipRegistratieLV = element.getElementsByTagName("Historie:tijdstipRegistratieLV").item(0).getTextContent();

                PndBagObjectVoorkomen pndBagObjectVoorkomen = new PndBagObjectVoorkomen();
                pndBagObjectVoorkomen.setVoorkomenidentificatie(voorkomenidentificatie);
                pndBagObjectVoorkomen.setBagObject(pndBagObject.getId().toString());
                pndBagObjectVoorkomen.setBeginGeldigheid(beginGeldigheid);
                pndBagObjectVoorkomen.setTijdstipRegistratie(tijdstipRegistratie);
                pndBagObjectVoorkomen.setTijdstipRegistratieLV(tijdstipRegistratieLV);
                this.pndBagObjectVoorkomenService.save(pndBagObjectVoorkomen);

            }
        }
        return data;
    }
}
