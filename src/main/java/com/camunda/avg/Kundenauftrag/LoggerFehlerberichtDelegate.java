package com.camunda.avg.KundenAuftrag;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
public class LoggerFehlerberichtDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(LoggerFehlerberichtDelegate.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    
	  LOGGER.info("\n\n[ERROR] Ausführen des Codes fehlgeschlagen!"
	            + "\n[ERROR] activtyName='" + execution.getCurrentActivityName() + "'"
	            + "\n[ERROR] processDefinitionId=" + execution.getProcessDefinitionId()
	            + "\n[ERROR] businessKey=" + execution.getProcessBusinessKey()
	            + "\n[ERROR] executionId=" + execution.getId()
	            + "\n[ERROR] variables=" + execution.getVariables()
	            + " \n\n");
    
  }

}
