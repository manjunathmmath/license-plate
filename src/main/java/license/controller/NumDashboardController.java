package license.controller;

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
import license.domain.num.*;
import license.service.CustomConfigurationService;
import license.service.num.*;

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
@RequestMapping("/num/api")
public class NumDashboardController {
    @Autowired
    private CustomConfigurationService customConfigurationService;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    NumBagObjectService numBagObjectService;

    @Autowired
    NumBagObjectStatusService numBagObjectStatusService;

    @Autowired
    NumBagObjectGeconstateerdService numBagObjectGeconstateerdService;

    @Autowired
    NumBagObjectDocumentnummerService numBagObjectDocumentnummerService;

    @Autowired
    NumBagObjectDocumentdatumService numBagObjectDocumentdatumService;

    @Autowired
    NumBagObjectVoorkomenService numBagObjectVoorkomenService;

    @Autowired
    NumBagObjectHuisletterService numBagObjectHuisletterService;

    @Autowired
    NumBagObjectHuisnummerService numBagObjectHuisnummerService;

    @Autowired
    NumBagObjectLigtAanService numBagObjectLigtAanService;

    @Autowired
    NumBagObjectPostcodeService numBagObjectPostcodeService;

    @Autowired
    NumBagObjectTypeAdresseerbaarObjectService numBagObjectTypeAdresseerbaarObjectService;


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
        columns.add("B.POSTCODE AS POSTCODE");
        columns.add("C.GECONSTATEERD AS GECONSTATEERD");
        columns.add("D.DOCUMENTDATUM AS DOCUMENTDATUM");
        columns.add("E.DOCUMENTNUMMER AS DOCUMENTNUMMER");
        columns.add("F.HUISNUMMER AS HUISNUMMER");
        columns.add("G.STATUS AS STATUS");
        columns.add("H.BEGIN_GELDIGHEID AS BEGIN_GELDIGHEID");
        columns.add("H.EIND_GELDIGHEID AS EIND_GELDIGHEID");
        columns.add("H.EIND_REGISTRATIE AS EIND_REGISTRATIE");
        columns.add("H.TIJDSTIP_EIND_REGISTRATIELV AS TIJDSTIP_EIND_REGISTRATIELV");
        columns.add("H.TIJDSTIP_REGISTRATIE AS TIJDSTIP_REGISTRATIE");
        columns.add("H.TIJDSTIP_REGISTRATIELV AS TIJDSTIP_REGISTRATIELV");
        columns.add("H.VOORKOMENIDENTIFICATIE AS VOORKOMENIDENTIFICATIE");
        columns.add("I.TYPE_ADRESSEERBAAR_OBJECT AS TYPE_ADRESSEERBAAR_OBJECT");
        columns.add("J.HUISLETTER AS HUISLETTER");
        columns.add("K.LIGT_AAN AS LIGT_AAN");

        String query = "";
        query += "SELECT " + String.join(",", columns);
        query += " FROM  ";
        query += " NUM_BAG_OBJECT A";
        query += " LEFT JOIN  NUM_BAG_OBJECT_POSTCODE B ON A.ID = B.BAG_OBJECT";
        query += " LEFT JOIN NUM_BAG_OBJECT_GECONSTATEERD C ON A.ID = C.BAG_OBJECT";
        query += " LEFT JOIN NUM_BAG_OBJECT_DOCUMENTDATUM D ON A.ID = D.BAG_OBJECT";
        query += " LEFT JOIN NUM_BAG_OBJECT_DOCUMENTNUMMER E ON A.ID = E.BAG_OBJECT";
        query += " LEFT JOIN NUM_BAG_OBJECT_HUISNUMMER F ON A.ID = F.BAG_OBJECT";
        query += " LEFT JOIN NUM_BAG_OBJECT_STATUS G ON A.ID = G.BAG_OBJECT";
        query += " LEFT JOIN NUM_BAG_OBJECT_VOORKOMEN H ON A.ID = H.BAG_OBJECT";
        query += " LEFT JOIN NUM_BAG_OBJECT_TYPE_ADRESSEERBAAR_OBJECT I ON A.ID = I.BAG_OBJECT";
        query += " LEFT JOIN NUM_BAG_OBJECT_HUISLETTER J ON A.ID = J.BAG_OBJECT";
        query += " LEFT JOIN NUM_BAG_OBJECT_LIGT_AAN K ON A.ID = K.BAG_OBJECT";

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
            row.put("ID", field[0] != null ? field[0].toString() : " ");
            row.put("FILE", field[1] != null ? field[1].toString() : " ");
            row.put("FOLDER", field[2] != null ? field[2].toString() : " ");
            row.put("IDENTIFICATIE", field[3] != null ? field[3].toString() : " ");
            row.put("POSTCODE", field[4] != null ? field[4].toString() : " ");
            row.put("GECONSTATEERD", field[5] != null ? field[5].toString() : " ");
            row.put("DOCUMENTDATUM", field[6] != null ? field[6].toString() : " ");
            row.put("DOCUMENTNUMMER", field[7] != null ? field[7].toString() : " ");
            row.put("HUISNUMMER", field[8] != null ? field[8].toString() : " ");
            row.put("STATUS", field[9] != null ? field[9].toString() : " ");
            row.put("BEGIN_GELDIGHEID", field[10] != null ? field[10].toString() : " ");
            row.put("EIND_GELDIGHEID", field[11] != null ? field[11].toString() : " ");
            row.put("EIND_REGISTRATIE", field[12] != null ? field[12].toString() : " ");
            row.put("TIJDSTIP_EIND_REGISTRATIELV", field[13] != null ? field[13].toString() : " ");
            row.put("TIJDSTIP_REGISTRATIE", field[14] != null ? field[14].toString() : " ");
            row.put("TIJDSTIP_REGISTRATIELV", field[15] != null ? field[15].toString() : " ");
            row.put("VOORKOMENIDENTIFICATIE", field[16] != null ? field[16].toString() : " ");
            row.put("TYPE_ADRESSEERBAAR_OBJECT", field[17] != null ? field[17].toString() : " ");
            row.put("HUISLETTER", field[18] != null ? field[18].toString() : " ");
            row.put("LIGT_AAN", field[19] != null ? field[19].toString() : " ");
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
            NumBagObject numBagObject = this.numBagObjectService.findByIdentificatie(identificatie);
            if (numBagObject == null) {
                numBagObject = new NumBagObject();
                numBagObject.setIdentificatie(identificatie);
                numBagObject.setFolder(dir);
                numBagObject.setFile(file);
                this.numBagObjectService.save(numBagObject);

                String status = element.getElementsByTagName("Objecten:status").item(0).getTextContent();

                if (isNotEmpty(status)) {
                    NumBagObjectStatus numBagObjectStatus = new NumBagObjectStatus();
                    numBagObjectStatus.setBagObject(numBagObject.getId().toString());
                    numBagObjectStatus.setStatus(status);
                    this.numBagObjectStatusService.save(numBagObjectStatus);
                }

                String geconstateerd = element.getElementsByTagName("Objecten:geconstateerd").item(0).getTextContent();
                if (isNotEmpty(geconstateerd)) {
                    NumBagObjectGeconstateerd numBagObjectGeconstateerd = new NumBagObjectGeconstateerd();
                    numBagObjectGeconstateerd.setBagObject(numBagObject.getId().toString());
                    numBagObjectGeconstateerd.setGeconstateerd(geconstateerd);
                    this.numBagObjectGeconstateerdService.save(numBagObjectGeconstateerd);
                }


                String documentdatum = element.getElementsByTagName("Objecten:documentdatum").item(0).getTextContent();

                if (isNotEmpty(documentdatum)) {
                    NumBagObjectDocumentdatum numBagObjectDocumentdatum = new NumBagObjectDocumentdatum();
                    numBagObjectDocumentdatum.setBagObject(numBagObject.getId().toString());
                    numBagObjectDocumentdatum.setDocumentdatum(documentdatum);
                    this.numBagObjectDocumentdatumService.save(numBagObjectDocumentdatum);
                }
                String documentnummer = element.getElementsByTagName("Objecten:documentnummer").item(0).getTextContent();
                if (isNotEmpty(documentnummer)) {
                    NumBagObjectDocumentnummer bagObjectDocumentnummer = new NumBagObjectDocumentnummer();
                    bagObjectDocumentnummer.setBagObject(numBagObject.getId().toString());
                    bagObjectDocumentnummer.setDocumentnummer(documentnummer);
                    this.numBagObjectDocumentnummerService.save(bagObjectDocumentnummer);
                }

                String voorkomenidentificatie = element.getElementsByTagName("Historie:voorkomenidentificatie").item(0).getTextContent();
                String beginGeldigheid = element.getElementsByTagName("Historie:beginGeldigheid").item(0).getTextContent();

                String eindGeldigheid = "";
                try {
                    eindGeldigheid = element.getElementsByTagName("Historie:eindGeldigheid").item(0).getTextContent();
                } catch (Exception e) {
                    System.out.println("Element not found Historie:eindGeldigheid");
                }

                String tijdstipRegistratie = "";
                try {
                    tijdstipRegistratie = element.getElementsByTagName("Historie:tijdstipRegistratie").item(0).getTextContent();
                } catch (Exception e) {
                    System.out.println("Element not found Historie:tijdstipRegistratie");
                }

                String eindRegistratie = "";
                try {
                    eindRegistratie = element.getElementsByTagName("Historie:eindRegistratie").item(0).getTextContent();
                } catch (Exception e) {
                    System.out.println("Element not found Historie:eindRegistratie");
                }

                String tijdstipRegistratieLV = "";
                try {
                    tijdstipRegistratieLV = element.getElementsByTagName("Historie:tijdstipRegistratieLV").item(0).getTextContent();
                } catch (Exception e) {
                    System.out.println("Element not found Historie:tijdstipRegistratieLV");
                }

                String tijdstipEindRegistratieLV = "";
                try {
                    tijdstipEindRegistratieLV = element.getElementsByTagName("Historie:tijdstipEindRegistratieLV").item(0).getTextContent();
                } catch (Exception e) {
                    System.out.println("Element not found Historie:tijdstipEindRegistratieLV");
                }


                NumBagObjectVoorkomen numBagObjectVoorkomen = new NumBagObjectVoorkomen();
                numBagObjectVoorkomen.setVoorkomenidentificatie(voorkomenidentificatie);
                numBagObjectVoorkomen.setBagObject(numBagObject.getId().toString());
                numBagObjectVoorkomen.setBeginGeldigheid(beginGeldigheid);
                numBagObjectVoorkomen.setEindGeldigheid(eindGeldigheid);
                numBagObjectVoorkomen.setEindRegistratie(eindRegistratie);
                numBagObjectVoorkomen.setTijdstipEindRegistratieLV(tijdstipEindRegistratieLV);
                numBagObjectVoorkomen.setTijdstipRegistratie(tijdstipRegistratie);
                numBagObjectVoorkomen.setTijdstipRegistratieLV(tijdstipRegistratieLV);
                this.numBagObjectVoorkomenService.save(numBagObjectVoorkomen);

                String huisnummer = "";
                try {
                    huisnummer = element.getElementsByTagName("Objecten:huisnummer").item(0).getTextContent();
                } catch (Exception e) {
                    System.out.println("Element not found Historie:huisnummer");
                }

                if (isNotEmpty(huisnummer)) {
                    NumBagObjectHuisnummer numBagObjectHuisnummer = new NumBagObjectHuisnummer();
                    numBagObjectHuisnummer.setBagObject(numBagObject.getId().toString());
                    ;
                    numBagObjectHuisnummer.setHuisnummer(huisnummer);
                    this.numBagObjectHuisnummerService.save(numBagObjectHuisnummer);
                }

                String huisletter = "";

                try {
                    huisletter = element.getElementsByTagName("Objecten:huisletter").item(0).getTextContent();
                } catch (Exception e) {
                    System.out.println("Element not found Historie:huisletter");
                }

                if (isNotEmpty(huisletter)) {
                    NumBagObjectHuisletter numBagObjectHuisletter = new NumBagObjectHuisletter();
                    numBagObjectHuisletter.setBagObject(numBagObject.getId().toString());
                    numBagObjectHuisletter.setHuisletter(huisletter);
                    this.numBagObjectHuisletterService.save(numBagObjectHuisletter);
                }

                String postcode = "";
                try {
                    postcode = element.getElementsByTagName("Objecten:postcode").item(0).getTextContent();
                } catch (Exception e) {
                    System.out.println("Element not found Historie:postcode");
                }

                if (isNotEmpty(postcode)) {
                    NumBagObjectPostcode numBagObjectPostcode = new NumBagObjectPostcode();
                    numBagObjectPostcode.setBagObject(numBagObject.getId().toString());
                    numBagObjectPostcode.setPostcode(postcode);
                    this.numBagObjectPostcodeService.save(numBagObjectPostcode);
                }

                String typeAdresseerbaarObject = "";
                try {
                    typeAdresseerbaarObject = element.getElementsByTagName("Objecten:typeAdresseerbaarObject").item(0).getTextContent();
                } catch (Exception e) {
                    System.out.println("Element not found Historie:typeAdresseerbaarObject");
                }
                if (isNotEmpty(typeAdresseerbaarObject)) {
                    NumBagObjectTypeAdresseerbaarObject numBagObjectTypeAdresseerbaarObject = new NumBagObjectTypeAdresseerbaarObject();
                    numBagObjectTypeAdresseerbaarObject.setBagObject(numBagObject.getId().toString());
                    numBagObjectTypeAdresseerbaarObject.setTypeAdresseerbaarObject(typeAdresseerbaarObject);
                    this.numBagObjectTypeAdresseerbaarObjectService.save(numBagObjectTypeAdresseerbaarObject);
                }

                String ligtAan = "";
                try {
                    ligtAan = element.getElementsByTagName("Objecten-ref:OpenbareRuimteRef").item(0).getTextContent();
                } catch (Exception e) {
                    System.out.println("Element not found Historie:OpenbareRuimteRef");
                }

                if (isNotEmpty(ligtAan)) {
                    NumBagObjectLigtAan numBagObjectLigtAan = new NumBagObjectLigtAan();
                    numBagObjectLigtAan.setBagObject(numBagObject.getId().toString());
                    numBagObjectLigtAan.setLigtAan(ligtAan);
                    this.numBagObjectLigtAanService.save(numBagObjectLigtAan);
                }
            }
        }
        return data;
    }
}
