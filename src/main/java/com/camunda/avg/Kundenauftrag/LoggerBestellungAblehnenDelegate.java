package com.camunda.avg.KundenAuftrag;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
public class LoggerBestellungAblehnenDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(LoggerBestellungAblehnenDelegate.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    
	  LOGGER.info("\n\n[LOG] Die Bestellung wurde abgelehnt"
	            + "\n[LOG] activtyName='" + execution.getCurrentActivityName() + "'"
	            + "\n[LOG] processDefinitionId=" + execution.getProcessDefinitionId()
	            + "\n[LOG] businessKey=" + execution.getProcessBusinessKey()
	            + "\n[LOG] executionId=" + execution.getId()
	            + "\n[LOG] variables=" + execution.getVariables()
	            + " \n\n");
    
  }

}
