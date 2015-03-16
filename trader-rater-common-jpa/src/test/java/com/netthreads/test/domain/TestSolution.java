package com.netthreads.test.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.netthreads.test.helper.CreateHelper;
import com.netthreads.test.system.PersistenceConfiguration;
import com.netthreads.trader.domain.Solution;
import com.netthreads.trader.domain.SolutionTaskJobType;
import com.netthreads.trader.domain.SolutionTaskType;
import com.netthreads.trader.domain.SolutionType;
import com.netthreads.trader.exception.DataLayerException;
import com.netthreads.trader.service.SolutionService;

/**
 * Test
 * 
 * @author Alistair
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration(classes =
{
		PersistenceConfiguration.class
})
public class TestSolution
{
	private static final Logger LOG = LoggerFactory.getLogger(TestSolution.class);
	
	private static int TEST_INDEX = 3;
	
	@Autowired
	private CreateHelper createHelper;
	
	@Autowired
	private SolutionService solutionService;
	
	@Before
	public void before()
	{
		LOG.info("Build injector");
	}
	
	@After
	public void after()
	{
		
	}
	
	/**
	 * Write.
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testWrite()
	{
		SolutionType serviceType = createHelper.createServiceType(TEST_INDEX);
		SolutionTaskType serviceTaskType = createHelper.createServiceTaskType(TEST_INDEX);
		SolutionTaskJobType serviceTaskJobType = createHelper.createServiceTaskJobType(TEST_INDEX);
		
		serviceTaskJobType.setOwner(serviceTaskType);
		serviceTaskType.setOwner(serviceType);
		
		Solution solution = new Solution();
		solution.setSolutionType(serviceType);
		
		solution = solutionService.save(solution);
		
		org.junit.Assert.assertTrue(solution.getId() != 0);
	}
	
}
