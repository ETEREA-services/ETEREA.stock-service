import json
from datetime import datetime
from jinja2 import Template
import os

def load_data():
    """Carga los datos de issues y milestones desde archivos JSON"""
    with open('data/issues.json', 'r') as f:
        issues = json.load(f)
    with open('data/milestones.json', 'r') as f:
        milestones = json.load(f)
    return issues, milestones

def generate_docs():
    """Genera la documentación del proyecto a partir de los datos de GitHub"""
    issues, milestones = load_data()
    
    # Template para la documentación
    template_str = """---
layout: default
title: Documentación Técnica del Proyecto
---

# Documentación Técnica del Proyecto

_Última actualización: {{ current_date }}_

## Resumen de Hitos del Proyecto

| Hito | Estado | Fecha Límite |
|-----------|--------|--------------|
{% for milestone in milestones %}
| {{ milestone.title }} | {{ milestone.state }} | {{ milestone.due_on if milestone.due_on else 'No definida' }} |
{% endfor %}

## Detalles de Hitos

{% for milestone in milestones %}
### {{ milestone.title }}
**Estado:** {{ milestone.state }}
**Descripción:** {{ milestone.description }}
{% if milestone.due_on %}**Fecha límite:** {{ milestone.due_on }}{% endif %}

---
{% endfor %}

## Incidencias Activas

{% for issue in issues if issue.state == 'open' %}
### #{{ issue.number }}: {{ issue.title }}
**Estado:** {{ issue.state }}
**Creado:** {{ issue.created_at }}
{% if issue.milestone %}**Hito:** {{ issue.milestone }}{% endif %}
{% if issue.labels %}**Etiquetas:** {{ issue.labels|join(', ') }}{% endif %}

{{ issue.body }}

---
{% endfor %}

## Incidencias Resueltas

{% for issue in issues if issue.state == 'closed' %}
### #{{ issue.number }}: {{ issue.title }}
**Estado:** {{ issue.state }}
**Creado:** {{ issue.created_at }}
**Resuelto:** {{ issue.closed_at }}
{% if issue.milestone %}**Hito:** {{ issue.milestone }}{% endif %}
{% if issue.labels %}**Etiquetas:** {{ issue.labels|join(', ') }}{% endif %}

{{ issue.body }}

---
{% endfor %}
"""
    
    template = Template(template_str)
    doc_content = template.render(
        current_date=datetime.now().strftime('%Y-%m-%d %H:%M:%S'),
        issues=issues,
        milestones=milestones
    )
    
    # Guardar la documentación
    with open('docs/project-documentation.md', 'w') as f:
        f.write(doc_content)

if __name__ == '__main__':
    generate_docs() 