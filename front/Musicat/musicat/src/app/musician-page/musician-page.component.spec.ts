import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicianPageComponent } from './musician-page.component';

describe('MusicianPageComponent', () => {
  let component: MusicianPageComponent;
  let fixture: ComponentFixture<MusicianPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MusicianPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MusicianPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
