import { Component } from '@angular/core';

export class Hero {
	id: number;
	name: string;
}

@Component({
	template: `
	<div class="angular-portlet">
		<h1>{{title}} test new 5</h1>
		<h2>{{hero.name}} details!</h2>
		<div><label>id: </label>{{hero.id}}</div>
		<div>
			<label>name: </label>
			<input [(ngModel)]="hero.name" placeholder="name">
		</div>
	</div>
	`
})
export class AppComponent {
	public sessionStorage = sessionStorage;
	
	hero: Hero = {
		id: 1,
		name: 'Windstorm'
	};
	title = 'Tour of Heroes';
}