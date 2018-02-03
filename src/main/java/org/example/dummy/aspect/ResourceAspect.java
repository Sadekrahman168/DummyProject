package org.example.dummy.aspect;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * 
 * @author sadekrahman
 * 
 *         Aspect Configuration Class to log basic API request and Exceptions.
 *
 *
 */

@Aspect
@Component

public class ResourceAspect {

	Logger log = LoggerFactory.getLogger(ResourceAspect.class);

	/**
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 * 
	 *             Log basic Http Request.
	 * 
	 */
	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public Object logRequest(final ProceedingJoinPoint joinPoint) throws Throwable {

		Object value = null;
		HttpServletRequest req = null;
		try {
			if (RequestContextHolder.getRequestAttributes() != null) {
				req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			}
			value = joinPoint.proceed();

		} catch (Throwable throwable) {
			log.info(throwable.getMessage());
		} finally {
			if (null != req) {
				log.info(String.format("[ method : %s ] with URI %s  has been called  from this IP %s", req.getMethod(),
						req.getRequestURI(), req.getRemoteAddr()));
			}
		}

		return value;
	}

}
