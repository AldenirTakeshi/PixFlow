DELIMITER
//

CREATE TRIGGER prevent_ledger_entries_update
    BEFORE UPDATE
    ON ledger_entries
    FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Operacao invalida: Registros do ledger sao imutaveis e nao podem ser alterados (UPDATE proibido).';
END;
//

CREATE TRIGGER prevent_ledger_entries_delete
    BEFORE DELETE
    ON ledger_entries
    FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Operacao invalida: Registros do ledger sao imutaveis e nao podem ser excluidos (DELETE proibido).';
END;
//

DELIMITER ;