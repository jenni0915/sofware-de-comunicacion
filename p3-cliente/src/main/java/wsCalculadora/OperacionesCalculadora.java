package wsCalculadora;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.6.1
 * 2023-12-05T13:38:33.104+01:00
 * Generated source version: 3.6.1
 *
 */
@WebService(targetNamespace = "http://calculadora/", name = "OperacionesCalculadora")
@XmlSeeAlso({ObjectFactory.class})
public interface OperacionesCalculadora {

    @WebMethod(action = "urn:ImplementacionRestar")
    @RequestWrapper(localName = "implementacionRestar", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionRestar")
    @ResponseWrapper(localName = "implementacionRestarResponse", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionRestarResponse")
    @WebResult(name = "return", targetNamespace = "")
    public double implementacionRestar(

        @WebParam(name = "arg0", targetNamespace = "")
        double arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1
    );

    @WebMethod(action = "urn:ImplementacionDividir")
    @RequestWrapper(localName = "implementacionDividir", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionDividir")
    @ResponseWrapper(localName = "implementacionDividirResponse", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionDividirResponse")
    @WebResult(name = "return", targetNamespace = "")
    public double implementacionDividir(

        @WebParam(name = "arg0", targetNamespace = "")
        double arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1
    ) throws Exception_Exception;

    @WebMethod(action = "urn:ImplementacionMultiplicar")
    @RequestWrapper(localName = "implementacionMultiplicar", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionMultiplicar")
    @ResponseWrapper(localName = "implementacionMultiplicarResponse", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionMultiplicarResponse")
    @WebResult(name = "return", targetNamespace = "")
    public double implementacionMultiplicar(

        @WebParam(name = "arg0", targetNamespace = "")
        double arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1
    );

    @WebMethod(action = "urn:ImplementacionSumar")
    @RequestWrapper(localName = "implementacionSumar", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionSumar")
    @ResponseWrapper(localName = "implementacionSumarResponse", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionSumarResponse")
    @WebResult(name = "return", targetNamespace = "")
    public double implementacionSumar(

        @WebParam(name = "arg0", targetNamespace = "")
        double arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1
    );

    @WebMethod(action = "urn:ImplementacionMA")
    @RequestWrapper(localName = "implementacionMA", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionMA")
    @ResponseWrapper(localName = "implementacionMAResponse", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionMAResponse")
    public void implementacionMA()
;

    @WebMethod(action = "urn:ImplementacionMO")
    @RequestWrapper(localName = "implementacionMO", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionMO")
    @ResponseWrapper(localName = "implementacionMOResponse", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionMOResponse")
    @WebResult(name = "return", targetNamespace = "")
    public double implementacionMO()
;

    @WebMethod(action = "urn:ImplementacionML")
    @RequestWrapper(localName = "implementacionML", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionML")
    @ResponseWrapper(localName = "implementacionMLResponse", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionMLResponse")
    public void implementacionML()
;

    @WebMethod(action = "urn:ImplementacionOperar")
    @RequestWrapper(localName = "implementacionOperar", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionOperar")
    @ResponseWrapper(localName = "implementacionOperarResponse", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionOperarResponse")
    @WebResult(name = "return", targetNamespace = "")
    public double implementacionOperar(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1
    );

    @WebMethod(action = "urn:ImplementacionGetOperaciones")
    @RequestWrapper(localName = "implementacionGetOperaciones", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionGetOperaciones")
    @ResponseWrapper(localName = "implementacionGetOperacionesResponse", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionGetOperacionesResponse")
    @WebResult(name = "return", targetNamespace = "")
    public List<String> implementacionGetOperaciones(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0
    );

    @WebMethod(action = "urn:ImplementacionUR")
    @RequestWrapper(localName = "implementacionUR", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionUR")
    @ResponseWrapper(localName = "implementacionURResponse", targetNamespace = "http://calculadora/", className = "wsCalculadora.ImplementacionURResponse")
    @WebResult(name = "return", targetNamespace = "")
    public double implementacionUR()
;
}
