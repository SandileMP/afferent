package services;

import DTOs.ResponseDTO;
import com.fathzer.soft.javaluator.DoubleEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AlgebraService {
    private Logger logger = LoggerFactory.getLogger(AlgebraService.class);

    public ResponseEntity<ResponseDTO> evaluate(String expression){
        if (workExpression(expression) == null){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO("Something went wrong while trying to evaluate expression",expression));
        }else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO("Expression evaluated",workExpression(expression)));
        }
    }
    private Double workExpression(String expression){
        logger.info("ALG, Attempting to work out expression");
        try {
            DoubleEvaluator eval = new DoubleEvaluator();
            Double answer = eval.evaluate(expression);
            return answer;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
