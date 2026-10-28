
package lab6;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface Calculator {

    @WebMethod
    int add(int a, int b);

    @WebMethod
    int subtract(int a, int b);

    @WebMethod
    int multiply(int a, int b);
}
