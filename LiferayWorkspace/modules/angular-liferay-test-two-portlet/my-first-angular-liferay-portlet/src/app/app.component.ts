import { Component } from '@angular/core';

import LiferayParams from '../types/LiferayParams'

declare const Liferay: any;

@Component({
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/my-first-angular-liferay-portlet/app/app.component.html'
})
export class AppComponent {
	params: LiferayParams;
	labels: any;

	constructor() {
		this.labels = {        
			
			configuration: 'Configuration',
			
			portletNamespace: 'Portlet Namespace',
        	contextPath: 'Context Path',
			portletElementId: 'Portlet Element Id',
		}
	}

	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}
}
