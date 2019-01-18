/*
 * Copyright (C) 2017 Sylvain Leroy - BYOSkill Company All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the MIT license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the MIT license with
 * this file. If not, please write to: sleroy at byoskill.com, or visit : www.byoskill.com
 *
 */
package io.github.sleroy.sonar;

import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;

import io.github.sleroy.sonar.model.EsLintRule;

public class EsLintRuleProfile implements BuiltInQualityProfilesDefinition {
	public static final String PROFILE_NAME = "EsLint";
	@Override
	public void define(Context context) {
		final NewBuiltInQualityProfile profile = context.createBuiltInQualityProfile(EsLintRuleProfile.PROFILE_NAME, EsLintLanguage.LANGUAGE_KEY);
		
		final EsRulesDefinition rules = new EsRulesDefinition();
		
		profile.activateRule(EsRulesDefinition.REPOSITORY_NAME, EsRulesDefinition.ESLINT_UNKNOWN_RULE.getKey());

		for (final EsLintRule coreRule : rules.getCoreRules()) {
			profile.activateRule(EsRulesDefinition.REPOSITORY_NAME, coreRule.getKey());
		}

		profile.done();
	}
}
