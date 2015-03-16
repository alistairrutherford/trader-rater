package com.netthreads.test.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.domain.SolutionType;
import com.netthreads.trader.exception.DataLayerException;
import com.netthreads.trader.service.SolutionTypeService;

/**
 * Test
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration(classes =
{
		PersistenceConfiguration.class
})
public class TestConnection
{
	@Autowired
	private SolutionTypeService solutionService; 

	@Test
	@Transactional
	public void testConnection() throws DataLayerException
	{
		Iterable<SolutionType> iterable = solutionService.findAll();
		
		org.junit.Assert.assertTrue(iterable.iterator().next() != null);
	}
}
