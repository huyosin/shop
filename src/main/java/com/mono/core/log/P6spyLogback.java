package com.mono.core.log;

import java.text.SimpleDateFormat;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.FileLogger;

public class P6spyLogback extends FileLogger {

	public String getLastEntry() {
		return lastEntry;
	}

	public void setLastEntry(String lastEntry) {
		this.lastEntry = lastEntry;
	}

	protected String lastEntry;

	@Override
	public void logSQL(int connectionId, String now, long elapsed, Category category, String prepared, String sql) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		logText(connectionId + "|" + elapsed + "|" + sdf.format(new Long(now)) + "|" + category.toString() + "|" + sql);
	}

}
