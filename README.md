# Table de Rappel

Application Android pour s'exercer à la mémorisation d'une suite de chiffres.

## Objectif

S'entraîner régulièrement et de façon permanente à mémoriser une suite de chiffres : retrouver le nombre associé à un mot (et inversement), vérifier sa réponse, et s'appuyer sur l'image associée pour consolider la mémorisation.

## Fonctionnalités

- **Chercher un mot** — saisir un mot pour retrouver son nombre associé
- **Chercher un nombre** — saisir un nombre pour retrouver son mot associé
- **Vérifier / Solution** — réponse immédiate après saisie
- **Images** — chaque association mot ↔ nombre possède une image
- **Galerie** — parcourir l'ensemble des images

## Données

Fichiers JSON embarqués dans `app/src/main/assets/json/` :

| Fichier | Rôle |
|---|---|
| `TBNom.json` | associations nom/mot |
| `TBNombre.json` | associations nombre |

## Technique

| Élément | Valeur |
|---|---|
| Langage | Kotlin |
| UI | Views classiques (XML, RecyclerView, CardView) |
| Sérialisation | Gson |
| SDK minimum | 26 (Android 8.0) |
| SDK cible / compilation | 34 (Android 14) |
| Build | Gradle Kotlin DSL + version catalog (`gradle/libs.versions.toml`) |

## Structure

```
app/src/main/java/fr/aghi/tablederappel/
├── MainActivity.kt              # accueil + navigation basse
├── ChercherMotsActivity.kt      # mot → nombre
├── ChercherNumerosActivity.kt   # nombre → mot
├── ImagesActivity.kt            # galerie d'images
├── model/Models.kt              # modèle de données
├── utils/JsonUtils.kt           # lecture des JSON (assets)
└── ui/dashboard/                # tableau de bord (Fragment + ViewModel)
```

## Build

- Ouvrir le projet dans **Android Studio** (SDK 34 requis)
- Ou en ligne de commande :

  ```bash
  ./gradlew assembleDebug
  ```

- APK généré : `app/build/outputs/apk/debug/app-debug.apk`
