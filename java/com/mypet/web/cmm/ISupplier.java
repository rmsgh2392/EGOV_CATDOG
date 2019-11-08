package com.mypet.web.cmm;
@FunctionalInterface
public interface ISupplier<R> {
	public R get();
}