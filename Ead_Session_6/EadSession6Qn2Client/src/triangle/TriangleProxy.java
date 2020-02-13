package triangle;

public class TriangleProxy implements triangle.Triangle {
  private String _endpoint = null;
  private triangle.Triangle triangle = null;
  
  public TriangleProxy() {
    _initTriangleProxy();
  }
  
  public TriangleProxy(String endpoint) {
    _endpoint = endpoint;
    _initTriangleProxy();
  }
  
  private void _initTriangleProxy() {
    try {
      triangle = (new triangle.TriangleServiceLocator()).getTriangle();
      if (triangle != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)triangle)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)triangle)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (triangle != null)
      ((javax.xml.rpc.Stub)triangle)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public triangle.Triangle getTriangle() {
    if (triangle == null)
      _initTriangleProxy();
    return triangle;
  }
  
  public java.lang.String area(java.lang.String side1, java.lang.String side2, java.lang.String side3) throws java.rmi.RemoteException{
    if (triangle == null)
      _initTriangleProxy();
    return triangle.area(side1, side2, side3);
  }
  
  
}