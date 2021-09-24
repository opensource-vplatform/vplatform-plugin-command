package com.yindangu.v3.command.timer;

import java.util.Collections;
import java.util.List;

import com.yindangu.v3.plugin.vds.reg.api.IRegisterPlugin;
import com.yindangu.v3.plugin.vds.reg.api.builder.IHttpCommandBuilder;
import com.yindangu.v3.plugin.vds.reg.api.model.IComponentProfileVo;
import com.yindangu.v3.plugin.vds.reg.api.model.IPluginProfileVo;
import com.yindangu.v3.plugin.vds.reg.common.RegVds;

public class CommandRegister  implements IRegisterPlugin {

	@Override
	public IComponentProfileVo getComponentProfile() {
		return RegVds.getPlugin().getComponentProfile()
				.setGroupId("com.yindangu.plugin.command")//机构id(groupId)不能修改
				.setCode("timerManager")//构件编码不能修改
				.build();
	}

	@Override
	public List<IPluginProfileVo> getPluginProfile() {
		IPluginProfileVo cmd = getHttpCommand();
		return Collections.singletonList(cmd);
	}
	private IPluginProfileVo getHttpCommand() {
		IHttpCommandBuilder cb = RegVds.getPlugin().getHttpCommandPlugin();
		IPluginProfileVo p3 = cb.setCode(TimerManagerCommand.CODE)
				.setName("定时器管理").setAuthor("jiqj")
				.setEntry(TimerManagerCommand.class)
				.setPagePath("pages")
				.build();
		return p3;
	}
}
