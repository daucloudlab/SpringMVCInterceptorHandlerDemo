package kz.tezdet.lessons.springmvc.interceptors;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeInterceptor extends HandlerInterceptorAdapter{
    private static final Logger logger = Logger.getLogger(TimeInterceptor.class) ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long time = System.currentTimeMillis() ;
        request.setAttribute("time", time);
        logger.info(" pre handle method, time in ms is: "+ time);
        return true ;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long totalTime = System.currentTimeMillis() - (Long)request.getAttribute("time");
        modelAndView.addObject("totalTime", totalTime);
        logger.info(" post handle method, totalTime passed: " + totalTime + "ms" );
    }
}
