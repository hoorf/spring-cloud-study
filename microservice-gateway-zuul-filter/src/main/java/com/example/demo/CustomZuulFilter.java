package com.example.demo;

import com.netflix.zuul.ZuulFilter;

public class CustomZuulFilter extends ZuulFilter {

	/**
	 * 执行逻辑
	 */
	@Override
	public Object run() {
		System.err.println("经过了zuul filter");
		return null;
	}

	/**
	 * 返回一个boolean类型来判断该过滤器是否要执行。我们可以通过此方法来指定过滤器的有效范围。
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 通过int值来定义过滤器的执行顺序，数值越小优先级越高
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 有三种可以选 pre：可以在请求被路由之前调用。 routing：在路由请求时候被调用。 post：在routing和error过滤器之后被调用。
	 * error：处理请求时发生错误时被调用。
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
