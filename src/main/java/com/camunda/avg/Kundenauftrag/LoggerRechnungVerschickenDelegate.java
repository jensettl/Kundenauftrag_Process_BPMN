package com.camunda.avg.KundenAuftrag;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
public class LoggerRechnungVerschickenDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(LoggerRechnungVerschickenDelegate.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    
	  LOGGER.info("\n\n[LOG] ===Rechnung==="
	            + "\n[LOG] activtyName='" + execution.getCurrentActivityName() + "'"
	            + "\n[LOG] processDefinitionId=" + execution.getProcessDefinitionId()
	            + "\n[LOG] processInstanceId=" + execution.getProcessInstanceId()
	            + "\n[LOG] executionId=" + execution.getId()
	            + "\n[LOG] variables=" + execution.getVariables()
	            + " \n\n");
    
  }

}
