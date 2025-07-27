import { Component, ElementRef, AfterViewInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit, OnDestroy {
  private mutationObserver!: MutationObserver;
  private intersectionObserver!: IntersectionObserver;
  private observedElements = new Set<Element>();

  constructor(private el: ElementRef) {}

  ngAfterViewInit(): void {
    if (typeof window === 'undefined') return;

    this.intersectionObserver = new IntersectionObserver((entries) => {
      entries.forEach(entry => {
        const el = entry.target as HTMLElement;
        if (entry.isIntersecting) {
          el.classList.add('fade-in');
          this.intersectionObserver.unobserve(el);
          this.observedElements.delete(el);
        }
      });
    }, { threshold: 0.1 });

    const observeAll = () => {
      const targets = this.el.nativeElement.querySelectorAll('.observe');
      targets.forEach((el: Element) => {
        if (!this.observedElements.has(el)) {
          this.intersectionObserver.observe(el);
          this.observedElements.add(el);
        }
      });
    };

    // Tenta observar imediatamente
    observeAll();

    // Observa mudanças no DOM
    this.mutationObserver = new MutationObserver(() => {
      observeAll();
    });

    this.mutationObserver.observe(this.el.nativeElement, {
      childList: true,
      subtree: true,
    });
  }

  ngOnDestroy(): void {
    this.mutationObserver?.disconnect();
    this.intersectionObserver?.disconnect();
    this.observedElements.clear();
  }
}
