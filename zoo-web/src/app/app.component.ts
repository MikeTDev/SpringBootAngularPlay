import { Component } from '@angular/core';
import { AnimalListComponent } from './animals/animal-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [AnimalListComponent],
  template: `
    <h1>Zoo Web</h1>
    <app-animal-list></app-animal-list>
  `
})
export class AppComponent {}