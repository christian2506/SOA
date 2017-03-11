
/* PROCEDIMIENTOS */

USE bdproduccion;

DELIMITER ;;
CREATE PROCEDURE sp_register_client (
IN nombreCli 	VARCHAR(30), 
IN codRubro 	CHAR(3), 
IN telefono 	VARCHAR(15), 
IN correo 		VARCHAR(60),
IN codEmp 		CHAR(5),
IN codServicio	CHAR(3), 
IN codTipoCom	CHAR(3), 
IN nivelInt		VARCHAR(15)
)
BEGIN
    DECLARE contador 	INT;
    DECLARE contador2 	INT;
    DECLARE contador3 	INT;
    DECLARE newCodigo 	CHAR(6);
    DECLARE newCodigo2 	CHAR(5);
    DECLARE newCodigo3 	CHAR(6);
    BEGIN
        SET contador = (SELECT COUNT(*)+1 FROM Cliente); 
        IF(contador<10)THEN
            SET newCodigo = CONCAT('C0000',contador);
			ELSE IF(contador<100) THEN
				SET newCodigo = CONCAT('C000',contador);
				ELSE IF(contador<1000)THEN
					SET newCodigo = CONCAT('C00',contador);
					ELSE IF(contador<10000)THEN
						SET newCodigo = CONCAT('C0',contador);
                        ELSE IF(contador<100000)THEN
							SET newCodigo = CONCAT('C',contador);
						END IF;
					END IF;
				END IF;
			END IF; 
		END IF;
	END;
    
    BEGIN
        SET contador2 = (SELECT COUNT(*)+1 FROM Actividad); 
        IF(contador2<10)THEN
            SET newCodigo2 = CONCAT('A000',contador2);
			ELSE IF(contador2<100) THEN
				SET newCodigo2 = CONCAT('A00',contador2);
				ELSE IF(contador2<1000)THEN
					SET newCodigo2 = CONCAT('A0',contador2);
					ELSE IF(contador2<10000)THEN
						SET newCodigo2 = CONCAT('A',contador2);
					END IF;
				END IF;
			END IF; 
		END IF;
	END;
    
    BEGIN
        SET contador3 = (SELECT COUNT(*)+1 FROM Detalle_Actividad); 
        IF(contador3<10)THEN
            SET newCodigo3 = CONCAT('D0000',contador3);
			ELSE IF(contador3<100) THEN
				SET newCodigo3 = CONCAT('D000',contador3);
				ELSE IF(contador3<1000)THEN
					SET newCodigo3 = CONCAT('D00',contador3);
					ELSE IF(contador3<10000)THEN
						SET newCodigo3 = CONCAT('D0',contador3);
                        ELSE IF(contador3<100000)THEN
							SET newCodigo3 = CONCAT('D',contador3);
						END IF;
					END IF;
				END IF;
			END IF; 
		END IF;
	END;
    
    BEGIN
		INSERT INTO Cliente   VALUES (newCodigo, nombreCli, codRubro, telefono, correo);
        INSERT INTO Actividad VALUES (newCodigo2, codEmp, newCodigo, now(), 'asdasd');
        INSERT INTO Detalle_Actividad VALUES (newCodigo3, newCodigo2, codServicio, codTipoCom, nivelInt, now());
    END;
END ;;

DELIMITER ;;
CREATE PROCEDURE sp_register_activity(
IN codCli 		CHAR(6), 
IN codServicio	CHAR(3), 
IN codTipoCom	CHAR(3), 
IN nivelInt		VARCHAR(15)
)
BEGIN
	DECLARE codActivity CHAR(5);
    DECLARE contador 	INT;
    DECLARE newCodigo 	CHAR(6);
    
    BEGIN
        SET contador = (SELECT COUNT(*)+1 FROM Detalle_Actividad); 
        SET codActivity = (SELECT Cod_Actividad FROM Actividad WHERE Cod_Cliente = codCli);
                            
        IF(contador<10)THEN
            SET newCodigo = CONCAT('D0000',contador);
			ELSE IF(contador<100) THEN
				SET newCodigo = CONCAT('D000',contador);
				ELSE IF(contador<1000)THEN
					SET newCodigo = CONCAT('D00',contador);
					ELSE IF(contador<10000)THEN
						SET newCodigo = CONCAT('D0',contador);
                        ELSE IF(contador<100000)THEN
							SET newCodigo = CONCAT('D',contador);
						END IF;
					END IF;
				END IF;
			END IF; 
		END IF;
	END;
    
    
    BEGIN
        INSERT INTO Detalle_Actividad VALUES (newCodigo, codActivity, codServicio, codTipoCom, nivelInt, now());
    END;
END ;;